package com.example.gateway.saga;

import com.example.command.NameGenerateCommand;
import com.example.workflow.GenerateNameSagaData;
import com.example.workflow.RejectionReason;
import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

@Service
@RequiredArgsConstructor
public class GenerateNameSaga  implements SimpleSaga<GenerateNameSagaData> {

    private SagaDefinition<GenerateNameSagaData> sagaDefinition =
            step()
                    //.invokeLocal(this::create)
                    //.withCompensation(this::reject)
                    //.step()
                    .invokeParticipant(this::generateName)
                    .onReply(UserNotFound.class, this::handleCustomerNotFound)
                    .step()
                    .invokeParticipant(this::updateStatistics)
                    .onReply(UserNotFound.class, this::handleCustomerNotFound)
                    .invokeLocal(this::approve)
                    .build();

    private void handleGenerateException(GenerateNameSagaData data, UserNotFound reply) {
        data.setRejectionReason(RejectionReason.UNKNOWN_USER);
    }

    private void handleUserNotFoundException(GenerateNameSagaData data, UserNotFound reply) {
        data.setRejectionReason(RejectionReason.INSUFFICIENT_CREDIT);
    }


    @Override
    public SagaDefinition<GenerateNameSagaData> getSagaDefinition() {
        return this.sagaDefinition;
    }

    private CommandWithDestination generateName(GenerateNameSagaData data) {
        return send(new NameGenerateCommand())
                .to("generatorService")
                .build();
    }

//    private void approve(GenerateNameSagaData data) {
//        orderService.approveOrder(data.getOrderId());
//    }
//
//    private void reject(GenerateNameSagaData data) {
//        orderService.rejectOrder(data.getOrderId(), data.getRejectionReason());
//    }
}
