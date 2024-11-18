
package com.example.nosuchmethodexception.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
@TestHTTPEndpoint(OperatorResource.class)
public class OperatorResourceIT extends OperatorResourceTest {
}
