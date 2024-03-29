package ru.nsu.valikov.models;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * Здесь хранятся основные и БОНУСНЫЕ задания, я не разделяю эти сущности.
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    public static final Map<Integer, Task> taskMap = new HashMap<>();

    @NonNull
    Integer id;
    @NonNull
    String name;
    @NonNull
    Integer score;

}
