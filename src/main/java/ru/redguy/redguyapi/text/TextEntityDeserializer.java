package ru.redguy.redguyapi.text;

import com.google.gson.*;

import java.lang.reflect.Type;

public class TextEntityDeserializer implements JsonDeserializer<TextEntity> {
    @Override
    public TextEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String dim = jsonObject.get("dim").getAsString();
        switch (dim) {
            case "amount-of-money": {
                return jsonDeserializationContext.deserialize(jsonElement, AmountOfMoneyEntity.class);
            }
            case "credit-card-number": {
                return jsonDeserializationContext.deserialize(jsonElement, CreditCardNumberEntity.class);
            }
            case "phone-number": {
                return jsonDeserializationContext.deserialize(jsonElement, PhoneNumberEntity.class);
            }
            case "number": {
                return jsonDeserializationContext.deserialize(jsonElement, NumberEntity.class);
            }
            case "distance": {
                return jsonDeserializationContext.deserialize(jsonElement, DistanceEntity.class);
            }
            case "duration": {
                return jsonDeserializationContext.deserialize(jsonElement, DurationEntity.class);
            }
            case "email": {
                return jsonDeserializationContext.deserialize(jsonElement, EmailEntity.class);
            }
            case "ordinal": {
                return jsonDeserializationContext.deserialize(jsonElement, OrdinalEntity.class);
            }
            case "quantity": {
                return jsonDeserializationContext.deserialize(jsonElement, QuantityEntity.class);
            }
            case "temperature": {
                return jsonDeserializationContext.deserialize(jsonElement, TemperatureEntity.class);
            }
            case "time": {
                return jsonDeserializationContext.deserialize(jsonElement, TimeEntity.class);
            }
            case "url": {
                return jsonDeserializationContext.deserialize(jsonElement, UrlEntity.class);
            }
            case "volume": {
                return jsonDeserializationContext.deserialize(jsonElement, VolumeEntity.class);
            }
        }
        return jsonDeserializationContext.deserialize(jsonElement, TextEntity.class);
    }
}
