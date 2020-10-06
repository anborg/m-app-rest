
Enable PROTO plugiin only for the duration of regenerate

!! !! Remember to add these annotation back to GENERATED classes!! !! !! !!

@JsonSerialize(using = SerializerGeneric.class)
@JsonDeserialize(using = DeserializeSearchRequest.class)
public  static final class SearchRequest extends


@JsonSerialize(using = SerializerGeneric.class)
public  static final class SearchResponse extends