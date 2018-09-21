package app.game.store.model.dto.json.serialize;

import java.text.ParseException;

import org.springframework.stereotype.Component;

@Component
public interface Serializer {

    <S> S deserialize(Class<S> clazz, String fileName) throws ParseException;
}
