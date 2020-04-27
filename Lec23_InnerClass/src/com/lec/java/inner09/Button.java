package com.lec.java.inner09;

public class Button {

	String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	// 클릭시 수행하는 리스너  제공
	// 리스너 인터페이스 : OnClickListener
	//         - 를릭시 동작 메소드 : onClick();
	// 장착 메소드 : setOnClickListener
	//---------------------------------------------------
	// 리스너 인터페이스
	public static interface OnClickListener { // Nested class
		void onClick(); //추상 메소드, 클릭했을 때 동작
		
	}
	
	// 장착 리스너
	private OnClickListener clickListener = null;
	
	// 리스너 장착 메소드
	public Button setOnclickListener(OnClickListener clickListener) {
		this.clickListener = clickListener;
		return this;
	}
	
	//----------------------------------------------
	public void actionClick() {
		System.out.println(name + " 버튼 클릭![시스템 기본동작 수행] ");
		
		if(clickListener != null)
			clickListener.onClick(); // 장착된 리스너 수행 
		
	}
	
	
	// 더블클릭시 수행하는 리스너를  제공해보세요
	// 리스너 인터페이스 : OnDblClickListener
		//         - 더블를릭시 동작 메소드 : onDblClick();
	// 장착 메소드 : setOnDblClickListener
	//---------------------------------------------------
	// 리스너 인터페이스
	public static interface OnDblClickListener {
		void onDblClick();
	}
	
	// 장착 리스너
	private OnDblClickListener dblClickListener = null;   

	// 리스너 장착 메소드
	public Button setOnDblClickListener(OnDblClickListener dblClickListener) {
		this.dblClickListener = dblClickListener;
		return this;
	}
	// TODO
	
	//----------------------------------------------
	public void actionDblClick() {
		System.out.println(name + " 버튼 더블 클릭![시스템 기본동작 수행]");
		if(dblClickListener != null)
			dblClickListener.onDblClick();
	}
	
	
	
	
} // end class
