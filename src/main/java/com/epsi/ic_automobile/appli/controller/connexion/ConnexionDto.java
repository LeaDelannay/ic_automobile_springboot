package com.epsi.ic_automobile.appli.controller.connexion;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnexionDto {

    @NotNull(message = "Vous devez renseigner l'email.")
    @Size(min = 1, message = "Vous devez renseigner l'email.")
    private String email;

    //TODO: implémenter le jwt token et ne plus demander le token mais le mot de passe.
    @NotNull(message = "Vous devez renseigner le mot de passe.")
    @Size(min = 1, message = "Vous devez renseigner le mot de passe.")
    private String token;

}
