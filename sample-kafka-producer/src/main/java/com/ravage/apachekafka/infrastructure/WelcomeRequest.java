package com.ravage.apachekafka.infrastructure;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WelcomeRequest {

    private String title;
    private String body;
}
