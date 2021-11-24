package com.example.exportpdf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2021/11/24 14:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreEntity implements Serializable {

    private static final long serialVersionUID = -6905326891716110202L;

    private String semester;

    private BigDecimal math;

    private BigDecimal language;

    private BigDecimal english;

    private BigDecimal chemical;

    private BigDecimal sports;

}
