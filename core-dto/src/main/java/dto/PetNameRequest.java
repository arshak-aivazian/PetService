package dto;

import dto.filter.Filter;
import lombok.Data;

@Data
public class PetNameRequest {
    private String username;
    private Filter filter;
}
