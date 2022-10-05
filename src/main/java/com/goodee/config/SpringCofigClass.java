package com.goodee.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//전체 환경 설정을 해주는 엔트리 클래스(여기가 시작점)
public class SpringCofigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	//여러가지 설정을 담고 있는 추상 클래스
	
	//프로젝트에서 사용할 Bean 들을 정의하기 위한 클래스를 지정한다.
	//MVC 패턴에서 컴포넌트 형태로 선언할 빈 말고 임시적으로 사용할 빈이 생길 수 있는데. 그런 빈들을 설정해주기 위한
	//클래스의 위치를 여기서 지정
	@Override  // ?는 와일드 카드 (어떤 클래스던지 들어가겠다,입력받겠다)
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	//Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	//MVC 에 필요한 여러 구성정보를 담은 클래스를 지정할 때 쓰는 메소드
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	//DispatcherServlet 에 매핑할 요청 주소를 세팅한다.
	@Override
	//지금까지 설정했던것들을 사용자들이 어떤 url로 접근을 할때 
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	//파라미터 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
	//해당 파라미터의 내용이 깨지는걸 방지하기위해 utf-8로 썼던것을 전역으로 설정해준 것
		//Request. 써가면서 일일이 할필요가 없음
	/* localhost8080/프로젝트명 */
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		return new Filter[] {encodingFilter};
	}
	

}
