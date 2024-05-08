//package ru.cotarius.remindermaven;
//
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@AutoConfigureMockMvc
//@RequiredArgsConstructor
//@WithMockUser(username = "test", password = "test", roles = {"ADMIN", "USER"})
//public class UserControllerTest {
//    private final MockMvc mockMvc;
//
//    @Test
//    void create() throws Exception {
//        mockMvc.perform(post("/registration")
//                        .param(name, "test@gmail.com")
//                        .param(firstname, "Test")
//                        .param(lastname, "TestTest")
//                        .param(role, "ADMIN")
//                        .param(companyId, "1")
//                        .param(birthDate, "2000-01-01")
//                )
//                .andExpectAll(
//                        status().is3xxRedirection(),
//                        redirectedUrlPattern("/users/{\\d+}")
//                );
//    }
//}
