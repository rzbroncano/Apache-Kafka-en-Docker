package com.ravage.apachekafka.infrastructure;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Reminder {

    //private List<Contact> contacts;
    private String title;
    private String body;
    private int repetitions;
}
