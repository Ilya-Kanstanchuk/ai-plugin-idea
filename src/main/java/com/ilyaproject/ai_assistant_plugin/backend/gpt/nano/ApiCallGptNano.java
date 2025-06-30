package com.ilyaproject.ai_assistant_plugin.backend.gpt.nano;

import com.ilyaproject.ai_assistant_plugin.backend.gpt.ApiCall;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

public class ApiCallGptNano implements ApiCall {
    public String callGPT(String prompt){
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        ResponseCreateParams params = ResponseCreateParams.builder()
                .input(prompt + ". Please return full working code")
                .model(ChatModel.GPT_4_1_NANO)
                .build();
        Response response = client.responses().create(params);
        return (response.output().get(0).asMessage().content().get(0).asOutputText().text());
    }


}
