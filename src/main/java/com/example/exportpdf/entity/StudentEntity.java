package com.example.exportpdf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2021/11/24 11:14
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements Serializable {

    private String name;

    private Integer age;

    private String height;

    private String weight;

    private String province;

    private String city;

    private String address;

    private String classes;

}
