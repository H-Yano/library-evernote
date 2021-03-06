package library.presentation.loan;

import library.LibraryDBTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@LibraryDBTest
@AutoConfigureMockMvc
class LoanRegisterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void 貸出画面が表示できる() throws Exception {
        mockMvc.perform(
                get("/loan/register"))
                .andExpect(status().isOk());
    }

    @Test
    public void 貸出が登録できる() throws Exception {
        mockMvc.perform(
                post("/loan/register")
                        .param("memberNumber.value", "1")
                        .param("itemNumber.value", "2-A")
                        .param("loanDate.value", "2011-11-11"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/loan/register/completed"));
    }
}