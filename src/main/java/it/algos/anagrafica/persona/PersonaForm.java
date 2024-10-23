package it.algos.anagrafica.persona;

import com.vaadin.flow.spring.annotation.SpringComponent;
import it.algos.vbase.entity.AbstractEntity;
import it.algos.vbase.form.DefaultForm;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@SpringComponent
@Scope(value = SCOPE_PROTOTYPE)
public class PersonaForm<T extends AbstractEntity> extends DefaultForm<T> {


    public PersonaForm(T bean) {
        super(bean);
    }

}
