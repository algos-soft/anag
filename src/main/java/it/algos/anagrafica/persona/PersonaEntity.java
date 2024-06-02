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

    @AFieldList(width = 6)
    @AField(type = TypeField.text)
    private String titolo;

    @AField(type = TypeField.text)
    private String nome;

    @AField(type = TypeField.text)
    private String cognome;

    @AFieldList(width = 8)
    @AField(type = TypeField.text)
    private String telefono;

    @AFieldList(width = 16)
    @AField(type = TypeField.text)
    private String mail;

    @AField(type = TypeField.linkDBRef)
    private AddressEntity address;

    @Override
    public String toString() {
        return nome + SPAZIO + cognome;
    }

}// end of Entity class
