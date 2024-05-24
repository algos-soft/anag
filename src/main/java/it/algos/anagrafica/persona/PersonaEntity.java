package it.algos.anagrafica.persona;

import it.algos.anagrafica.address.*;
import it.algos.vbase.backend.annotation.*;
import static it.algos.vbase.backend.boot.BaseCost.*;
import it.algos.vbase.backend.entity.*;
import it.algos.vbase.backend.enumeration.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address")
@AEntity()
public class PersonaEntity extends AbstractEntity {

    @AField(type = TypeField.text, widthList = 6)
    private String titolo;

    @AField(type = TypeField.text)
    private String nome;

    @AField(type = TypeField.text)
    private String cognome;

    @AField(type = TypeField.text, widthList = 8)
    private String telefono;

    @AField(type = TypeField.text, widthList = 16)
    private String mail;

    @AField(type = TypeField.linkDBRef)
    private AddressEntity address;

    @Override
    public String toString() {
        return nome + SPAZIO + cognome;
    }

}// end of Entity class
