package com.fazliddin.library.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DistrictDTO {
    private Long id;

    private String name;

    private Long regionId;
}
