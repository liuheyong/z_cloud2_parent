package com.cloud2.swaggerapi;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class ZCloud2SwaggerApiApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZCloud2SwaggerApiApplication.class).web(true).run(args);
    }

    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            /*zcloud2swaggera zcloud2swaggerb 必须是小写*/
            /*因为zuul给微服务生成的匹配规则默认都是小写的*/
            /* /zcloud2swaggera/**  /zcloud2swaggerb/** */
            resources.add(swaggerResource("z_cloud2_swagger_a", "/zcloud2swaggera/v2/api-docs", "2.0"));
            resources.add(swaggerResource("z_cloud2_swagger_b", "/zcloud2swaggerb/v2/api-docs", "2.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}
