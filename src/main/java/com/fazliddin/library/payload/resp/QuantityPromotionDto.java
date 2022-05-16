package com.fazliddin.library.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QuantityPromotionDto {
    private Long id;
    private ProductRespDto productRespDto;
    private Integer quantity;
}
