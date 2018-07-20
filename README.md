# Struts2Board
참고 : http://blog.naver.com/PostList.nhn?blogId=fourleaf0311&from=postList&categoryNo=103

해당 블로그를 참고하여 게시판 작성
1. 게시판 목록 
2. 게시판 쓰기
   - 게시판 작성하는 화면은 보여주고 있으나, 작성 불가
   - 해당 오류 발생
     (There is no result type defined for type 'redirect-action' mapped with name 'success'.  Did you mean 'redirectAction'? )
   - 해당 원인 찾는중으로, 'struts.xml'에서 오류 발생하는 부분 주석처리 

3. 게시판 상세보기
4. 파일 다운로드
5. 비밀번호체크
6. 게시판 수정
7. 게시판 삭제

-> 게시판 작성 오류로 인하여 3번~7번까지 테스트 
