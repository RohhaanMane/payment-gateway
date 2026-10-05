package com.rohan.payment_gateway.merchant.mapper;


import com.rohan.payment_gateway.merchant.dto.response.ApiKeyCreateResponse;
import com.rohan.payment_gateway.merchant.dto.response.ApiKeyResponse;
import com.rohan.payment_gateway.merchant.entity.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {

    ApiKeyCreateResponse toCreateResponse(ApiKey apiKey);

    List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList);
}
