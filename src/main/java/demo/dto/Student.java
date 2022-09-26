package demo.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Student {
    private final int id;
    private final String name;
}
