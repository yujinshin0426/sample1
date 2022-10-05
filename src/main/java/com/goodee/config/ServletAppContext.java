package com.goodee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
//Controller 어노테이션이 세팅되어 있는 클래스를 등록하는 어노테이션
@EnableWebMvc
//스캔할 패키지 지정

@ComponentScan("com.goodee.controller")
public class ServletAppContext implements WebMvcConfigurer{//스프링에서 제공하고있는 인터페이스,  기존에있던것(Spring core)과 달리 스프링웹MVC에 특화된 것을 만들고자할 때 사용 
	//혼자 못움직임, component scan하고 꼭 같이 움직여야함
	//컨트롤러라는 어노테이션이 담긴 클래스, 관련된 모든 정보가 여기에서 구성되어 있음
	//Controller 의 메소드가 반환되는 jsp의 이름 앞뒤에 경로와 확장자를 붙여주도록 설정한다.
	
	
	@Override //리턴한 스트링 데이터의 앞과 뒤의 문장을 합쳐서 우리가 불러올 뷰의 경로를 알아서 설정해줌
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
		
		
	}
	
	//정적 파일의 경로 세팅 ,영상 오디오파일 그림 등등을 어느경로에 따라 써야하느냐 할때
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
									//로 시작하게된다면 (* 주의해서 사용해야함 )
		registry.addResourceHandler("/resource/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///D:/sample/"); //인덱스 참조
		/* 어떤경로로든 접근하게되면 난 resources를 바라보겠다 (webapp 안에 있는)  */
		
	}
	
	// 파일 업로드 세팅
	private final int MAX_SIZE = 10 * 1024 * 1024;
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		// 디폴트 인코딩 타입 설정
		multipartResolver.setDefaultEncoding("UTF-8");
		
		// 전체 올릴 수 있는 파일들의 총 용량 최대치
		multipartResolver.setMaxUploadSize(MAX_SIZE*10);
		
		// 파일 한개당 올릴 수 있는 용량 최대치
		multipartResolver.setMaxUploadSizePerFile(MAX_SIZE);
		// 
		
		return multipartResolver;
	}
	
	
	
	
}
