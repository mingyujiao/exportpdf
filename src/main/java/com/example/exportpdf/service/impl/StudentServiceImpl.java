package com.example.exportpdf.service.impl;

import com.example.exportpdf.entity.ScoreEntity;
import com.example.exportpdf.entity.StudentEntity;
import com.example.exportpdf.service.StudentService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2021/11/24 11:13
 */
@Service
public class StudentServiceImpl implements StudentService {

    public static final String TEMPLATE_PATH = "templates"+ File.separator;

    // TODO 修改生成PDF路径
    private static final String FILE_PATH = "C:\\Users\\29109\\Desktop\\test.pdf";

    @Override
    public void exportStudentPDF() {

        Map<String, Object> paramMap = getMapData();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(getEntities());
        ClassPathResource resource = new ClassPathResource(TEMPLATE_PATH + "StudentDetails.jasper");
        try {
            InputStream inputStream = resource.getInputStream();
            // 详情 + 表头
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, paramMap, dataSource);
            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            FileOutputStream outFile = new FileOutputStream(FILE_PATH);
            outFile.write(bytes);
            outFile.close();
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> getMapData() {

        StudentEntity student = StudentEntity.builder()
                .classes("三年二班")
                .name("张三")
                .age(18)
                .height("180CM")
                .weight("70KG")
                .province("河北省")
                .city("石家庄")
                .address("新华区西三庄街道某个小区一单元88号")
                .build();
        return Arrays.stream(BeanUtils.getPropertyDescriptors(student.getClass()))
                .filter(itm -> !"class".equals(itm.getName()))
                .collect(HashMap::new,
                        (map, pd) -> map.put(pd.getName(), ReflectionUtils.invokeMethod(pd.getReadMethod(), student)),
                        HashMap::putAll);
    }

    private List<ScoreEntity> getEntities() {
        List<ScoreEntity> scoreEntities = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            scoreEntities.add(
                    ScoreEntity.builder()
                            .semester("第" + i + "学期")
                            .chemical(new BigDecimal("70").add(new BigDecimal(i)))
                            .math(new BigDecimal("60").add(new BigDecimal(i)))
                            .language(new BigDecimal("80").add(new BigDecimal(i)))
                            .english(new BigDecimal("50").add(new BigDecimal(i)))
                            .sports(new BigDecimal("90").add(new BigDecimal(i)))
                            .build()
            );
        }

        return scoreEntities;
    }

}
