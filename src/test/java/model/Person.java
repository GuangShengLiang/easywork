package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-7 下午3:58
 */
@Data
@AllArgsConstructor
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
}
