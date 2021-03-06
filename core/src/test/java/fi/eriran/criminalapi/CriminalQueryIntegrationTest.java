package fi.eriran.criminalapi;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import fi.eriran.criminalapi.testcore.util.filepath.QueryFilePathProvider;
import fi.eriran.criminalapi.testcore.util.filepath.ResponseFilePathProvider;
import fi.eriran.criminalapi.testcore.annotation.CriminalApiSpringBootTest;
import io.micrometer.core.instrument.util.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@CriminalApiSpringBootTest
class CriminalQueryIntegrationTest {

    @Autowired
    private GraphQLTestTemplate testTemplate;

    @Test
    void fullCriminalQuery() throws IOException, JSONException {
        GraphQLResponse response = testTemplate
                .postForResource(new QueryFilePathProvider().provide("fullCriminal"));
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //todo: when calling the real api, it will return the timestamp in UTC but in the GraphQLTestTemplate it is
        // returns it with timezone added into the utc time. The expected response is here is the one from testTemplate
        JSONAssert.assertEquals(readFile("fullCriminal"), response.getRawResponse().getBody(), true);
    }

    private String readFile(String fileName) throws IOException {
        String filePath = new ResponseFilePathProvider().provide(fileName);
        return IOUtils.toString(new ClassPathResource(filePath).getInputStream(), StandardCharsets.UTF_8);
    }
}
