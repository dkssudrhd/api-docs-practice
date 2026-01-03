package com.hmgblog.apidocspractice.controller;

import com.hmgblog.apidocspractice.docs.BaseDocumentTest;
import com.hmgblog.apidocspractice.dto.TestResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {TestController.class})
class TestControllerTest extends BaseDocumentTest {

    TestResponse response = new TestResponse(1L, "Test Title", "Test Content");

    @Test
    @DisplayName("Get() 으로 Test 가져오기")
    void getTest() throws Exception {


        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/test/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo((document(snippetPath,
                        pathParameters(
                                parameterWithName("id").description("Test의 id")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("test의 id"),
                                fieldWithPath("title").type(JsonFieldType.STRING).description("test의 title"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("test의 content")
                        )

                )));

    }

    @Test
    void postTest() {
    }
}