package com.july.shop.api.goods;


import com.july.shop.api.dto.product.output.ProductDto;
import com.july.shop.common.base.entity.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 
 * @author july
 * @description: 商品搜索服务接口
 */
public interface ProductSearchService {

	@GetMapping("/search")
	public BaseResponse<List<ProductDto>> search(String name);

}
