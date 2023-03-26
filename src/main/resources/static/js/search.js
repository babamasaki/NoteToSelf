$(function() {
	  $("#note_form").on("submit", function(e) {
	    e.preventDefault();  // デフォルトのイベント(ページの遷移やデータ送信など)を無効にする
	    $.ajax({
	      url: $(this).attr("action"),  // リクエストを送信するURLを指定（action属性のurlを抽出）
	      type: "POST",  // HTTPメソッドを指定（デフォルトはGET）
	      data: {
	        note: $("#note").val()  // 送信データ
	      },
	      dataType: "json"  // レスポンスデータをjson形式と指定する
	    })
	    .done(function(rows) {
		  var table = document.getElementById("table_id");
		  var length = table.rows.length;
		  for(let i = 0; i < length -1; i++){
			  // 2行目を削除
			  table.deleteRow(1);
		  }
//          console.log(rows);
		  for(let row of Object.keys(rows)) {
	          let newRow = table.insertRow(-1);
	          newRow.classList.add('tableTrMain');
	          newRow.setAttribute('id',"content-" + rows[row]['memoId']);
	          newRow.setAttribute('data-href',"/NoteToSelf/showMemo/" + rows[row]['memoId']);
	          // クリックイベントをどう実装しようかな？？
//	          console.log(rows[row]);
	          for(let cell of  Object.keys(rows[row])) {
	        	  let newCell = newRow.insertCell(-1);
	        	  newCell.classList.add('tableTdMain');
	        	  let slicetext =  rows[row][cell];
//	        	  console.log(rows[row]);
	        	  newCell.textContent = slicetext.length > 25 ? (slicetext).slice(0,24)+"…" : slicetext;
			  }
	      }
		  $('tr[data-href]').click(function (e) {
		      if (!$(e.target).is('a')) {
		      	  window.location = $(e.currentTarget).data('href');
		      };
		  });
	    })
	    .fail(function() {
	      alert("error!");  // 通信に失敗した場合の処理
	    })
	  });
	});