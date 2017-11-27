package com.mindster.service;

import com.mindster.DTO.MoztrapDto.MoztrapResponseMainDto;
import org.springframework.context.annotation.Configuration;

import static com.mindster.service.JiraService.convertJsonToDTO;

/**
 * Created by srinidhis on 17/12/16.
 */
@Configuration
public class MoztrapService {
    protected String destinationDirectory=System.getProperty("user.dir");
    private final String MOZTRAP_TEST_CASE_PATH = destinationDirectory + "/src/main/testData/moztrap/";

    public MoztrapResponseMainDto getMoztrapDTOFromJson(String caseId) throws Exception{
//        FileReader fileReader = new FileReader(MOZTRAP_TEST_CASE_PATH+"moz-"+caseId+".json");
//        JSONParser jsonParser = new JSONParser();
//        Object jsonObject1 = jsonParser.parse(fileReader);
        String mozJson = "{\n" +
                "  \"id\": \"4292\",\n" +
                "  \"name\": \"Delete an Email from Platform from Thirdpane message workflow\",\n" +
                "  \"tags\": [\n" +
                "    \"Smoke\",\n" +
                "    \"Regression\"\n" +
                "  ],\n" +
                "  \"suites\": [\n" +
                "    \"Gmail\"\n" +
                "  ],\n" +
                "  \"created_by\": \"vsajjan@test.com\",\n" +
                "  \"priority\": 0,\n" +
                "  \"steps\": [\n" +
                "    {\n" +
                "      \"instruction\": \"PRE-REQUISITE: Client property for Email should be enabled\",\n" +
                "      \"expected\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"instruction\": \" Login to WebUI.\\n\",\n" +
                "      \"expected\": \" Login must be successfull\\n\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"instruction\": \" Add GMAIL column by seleting the Account name.\\n\",\n" +
                "      \"expected\": \" GMAIL Clolumn should be added\\n\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"instruction\": \" Click on delete for a particular message from thirdpane message workflow\\n\",\n" +
                "      \"expected\": \" The message should be deleted from message cell\\n\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"instruction\": \" Verify from channel for is the post is deleted\",\n" +
                "      \"expected\": \" In channel the the deleted post should not be seen\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return  (MoztrapResponseMainDto)convertJsonToDTO(mozJson,MoztrapResponseMainDto.class.getName());
    }
}
