package model;

import lombok.Data;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-7 下午3:58
 */
@Data
public class Human {
    private String firstName;
    private String lastName;
    private List<Person> persons;
}
