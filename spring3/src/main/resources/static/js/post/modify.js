/**
 * 포스트 업데이트 & 삭제
 */

document.addEventListener('DOMContentLoaded', ()=> {
	
	const postModifyForm = document.querySelector('#postModifyForm');
	
	const btnUpdate = document.querySelector('#btnUpdate');
	btnUpdate.addEventListener('click', (e) =>{
		alert("업데이트");
		 // TODO: 포스트 업데이트
		 // 제목과 내용이 입력되어 있는 지 체크.
        /** 
		const title = document.querySelector('input#title').value; // input에 입력된 값.
        const content = document.querySelector('textarea#content').value; // textarea에 입력된 값.
        if (title === '' || content === '') {
            alert('제목과 내용은 반드시 입력하세요.');
            return; // 함수 종료
        }
        
        const check = confirm('변경 내용을 저장할까요?');
        if (check) {
            postModifyForm.action = './update'; // 폼 요청 주소
            postModifyForm.method = 'post'; // 폼 요청 방식
            postModifyForm.submit();
        }
        */
	   const title = document.querySelector('#title').value;
	   const content = document.querySelector('#content').value;
	   if(title === '' || content ==='') {
		   alert('제목과 내용은 반드시 입력...');
		   return;
	   }
	   
	   const result = confirm('변경된 내용을 업데이트할까요?')
	   if(!result){
		   return;
	   }
	   
	   postModifyForm.action = '/post/update';
	   postModifyForm.method = 'post';
	   postModifyForm.submit();
	   
	});	
	
	const btnDelete = document.querySelector('#btnDelete');
	btnDelete.addEventListener('click', (e)=>{
		alert('삭제');
		// TODO: 포스트 삭제
		/**
		const check = confirm('정말 삭제할까요?');
        if (check) {
            postModifyForm.action = './delete'; // 'delete' // 폼 요청 주소
            postModifyForm.method = 'post'; // 폼 요청 방식
            postModifyForm.submit(); // 폼 제출 -> 요청을 서버로 보냄.
           */
		const result = confirm('정말 삭제할까요?');
		if(!result){
			return;
		}
        postModifyForm.action = '/post/delete'; // submit 요청 주소
        postModifyForm.method = 'post'; // submit 요청 방식
        postModifyForm.submit(); // 폼 제출(submit), 요청 보내기.
	});
});