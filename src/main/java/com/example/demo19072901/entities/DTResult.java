package com.example.demo19072901.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTResult<T> {

    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;

}
