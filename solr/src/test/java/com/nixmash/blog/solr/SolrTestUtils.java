/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nixmash.blog.solr;

import com.nixmash.blog.solr.enums.SolrDocType;
import com.nixmash.blog.solr.model.PostDoc;
import com.nixmash.blog.solr.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * NixMash Spring Notes: ---------------------------------------------------
 * 
 * Based on Christoph Strobl's Spring Solr Repository Example for Spring Boot
 * 
 * On GitHub: https://goo.gl/JoAYaT
 * 
 */
public abstract class SolrTestUtils {

	public static List<String> categories = Collections.singletonList("test");
	public static List<String> tags = Arrays.asList("testone", "testtwo");


	public static List<Product> createProductList(int nrProducts) {
		List<Product> products = new ArrayList<Product>(nrProducts);
		for (int i = 0; i < nrProducts; i++) {
			products.add(createProduct(i));
		}
		return products;
	}

	protected static Product createProduct(int id) {
		Product product = new Product();
		product.setId(Integer.toString(id));
		product.setAvailable(id % 2 == 0);
		product.setName("product-" + id);
		product.setPopularity(id * 10);
		product.setCategories(categories);
		product.setPrice((float) id * 100);
		product.setWeight((float) id * 2);
		product.setLocation(null);
		product.setDoctype(SolrDocType.PRODUCT);
		return product;
	}

	public static List<PostDoc> createPostDocList(int nrPosts) {
		List<PostDoc> postDocs = new ArrayList<PostDoc>(nrPosts);
		for (int i = 1; i < nrPosts + 1; i++) {
			postDocs.add(createPostDoc(i));
		}
		return postDocs;
	}

	protected static PostDoc createPostDoc(int id) {
		PostDoc postDoc = new PostDoc();
		postDoc.setPostId(Integer.toString(id));
		postDoc.setPostTitle("Post Title " + id);
		postDoc.setPostAuthor("mintster");
		postDoc.setPostName("post-title-" + id);
		postDoc.setPostLink(id % 2 == 0 ? "" : "http://somewhere/" + id);
		postDoc.setPostType(id % 2 == 0 ? "POST" : "LINK");
		postDoc.setPostHTML("<strong>Post HTML</strong> " + id);
		postDoc.setPostText("Post Content " + id);
		postDoc.setPostSource(id % 2 == 0 ? "somewhere.com" : "NA");
		postDoc.setTags(tags);
		postDoc.setDocType(SolrDocType.POST);
		return postDoc;
	}
}
