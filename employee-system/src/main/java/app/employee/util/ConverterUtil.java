package app.employee.util;

import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class ConverterUtil {

	private static ModelMapper mapper = new ModelMapper();
	
	private ConverterUtil() {
	}

	public static <S, D> D convert(S source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}
	
	public static <S, D> D convertCustom(S sourceType, Class<D> destClass, ExpressionMap<S, D>... exprMap) {
		TypeMap<S, D> typeMap = mapper.createTypeMap(sourceType, destClass);
		for (ExpressionMap<S, D> expressionMap : exprMap) {
			typeMap.addMappings(expressionMap);
		}
		return typeMap.map(sourceType);
	}
	
}
