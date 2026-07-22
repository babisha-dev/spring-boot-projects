@Configuration
public class config{
    @Bean
    public OpenAPI customOpenAPI(){
        @Bean
        return new OpenAPI()
                .info(new Info()
                        .title("College & Students Registration API")
                        .version("1.0.0")
                        .description("API for managing college and student registration"))
                .contact(new Contact()
                        .name("Your Name")
                        .email("name@gmaik.com")
                        .url("https.example.com"))
                .license(new License()
                         .name("Apache 2.0")
                         .url("https://spring.docs"))
                .addTagsItem(new Tag()
                        .name("student management")
                        .description("operation related to student management"))
                .addTagsItem(new Tag()
                        .name("college management")
                        .description("operations related to college management"))
    }
}