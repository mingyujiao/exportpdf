package com.example.exportpdf;

import com.example.exportpdf.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2021/11/24 16:30
 */

@SpringBootTest
public class StudentServiceTests {

    @Autowired
    private StudentService studentService;

    @Test
    void exportStudentPDFTest() {
        studentService.exportStudentPDF();
    }
}
