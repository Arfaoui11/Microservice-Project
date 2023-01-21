package io.microservice.formationdataservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationPlaceEvent {
    private String formationTitile;
}
