package com.example.gateway.saga;

import com.example.workflow.GenerateNameSagaData;
import io.eventuate.tram.sagas.orchestration.SagaInstanceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class GenerateNameService {
    private final SagaInstanceFactory sagaInstanceFactory;
    private final GenerateNameSaga createOrderSaga;

    @Transactional
    public void createGenerateNameSaga() {
        GenerateNameSagaData data = new GenerateNameSagaData();
        sagaInstanceFactory.create(createOrderSaga, data);
    }
}
