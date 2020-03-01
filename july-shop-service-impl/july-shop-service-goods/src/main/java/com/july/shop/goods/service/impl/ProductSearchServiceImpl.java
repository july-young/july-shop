package com.july.shop.goods.service.impl;

import com.july.shop.api.dto.product.output.ProductDto;
import com.july.shop.api.goods.ProductSearchService;
import com.july.shop.common.base.api.BaseApiService;
import com.july.shop.common.base.entity.BaseResponse;
import com.july.shop.goods.es.entity.ProductEntity;
import com.july.shop.goods.es.util.EsUtil;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author july
 */
@RestController
public class ProductSearchServiceImpl extends BaseApiService<List<ProductDto>> implements ProductSearchService {
	@Autowired
	private EsUtil esUtil;

	@Override
	public BaseResponse<List<ProductDto>> search(String name) {
		// 1.拼接查询条件
		BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
		// 2.模糊查询name字段
		boolBuilder.filter(QueryBuilders.fuzzyQuery("name", name));

		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.query(boolBuilder);
		sourceBuilder.from(0);
		sourceBuilder.size(100);
		// 3.调用ES接口查询
		List<ProductEntity> content = esUtil.search("goods",sourceBuilder,ProductEntity.class);

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		List<ProductDto> mapAsList = mapperFactory.getMapperFacade().mapAsList(content, ProductDto.class);
		return setResultSuccess(mapAsList);
	}
}
