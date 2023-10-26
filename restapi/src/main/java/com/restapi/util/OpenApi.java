package com.restapi.util;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Loyalty System Api",
                description = "Loyalty System", version = "1.0.0",
                contact = @Contact(
                        name = "Roman Akhmetgaraev",
                        email = "akhmetgaraevrr@yandex.ru",
                        url = "https://t.me/Oraleecy" // Подставить сайт визитку
                )
        )
)
public class OpenApi {
}
