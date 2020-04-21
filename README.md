# Overview
Learn Java and Make Some Projects

# Small Project
### [01：Subjects Print](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/01_subjects_print.java)   
藉由 keyboard.nextInt() 、 keyboard.next() 、 keyboard.nextInt() 以及矩陣的使用，儲存使用者輸入的學科名稱、學分之後，再把矩陣內的資料印出。    
>
### [02：Change Money](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/02_change_money.java)   
利用javax中的JOptionPane工具，寫出一對話框。該程式能自動地將使用者輸入的數字，換算成最少的鈔票、硬幣組合。本身學過 Tkinter 和 QT ，覺得需求沒有太高， Tkinter 或 JOptionPane 就能滿足需求了。   
![](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/Change%20Money%20Result.JPG)
>
### [03：Loops Score](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/03_loops_score.java)   
再次利用 Javax 中的 JOptionPane ，設計一個能計算平均成績且統計及格數與不及格數的程式。下方的五張圖片是對話框的樣貌。程式碼為一個無限迴圈，只有在使用者於「是否繼續輸入分數?」選擇「Yes」的時候，才會藉由 if 和 break 的跳出迴圈。    
![](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/Loops%20Score%20Result.JPG)
>
### [04：Heater](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/04_Heater.java)    
藉由物件導向程式設計中的物件、多載、建構子、Static Method 等概念，寫出Heater這個類別。我一共寫了 printTemp、warmer、setIncrement、cooler、printHeaterNum、getHeaterNum、getTemp等多個方法。其中，Heater 建構子有用到多載的概念；cooler和warmer裡則有另外一個函數，limitTemp。當升溫或降溫後，若溫度是該加熱器無法承受的，limitTemp會印出錯誤訊息，並回傳1，使得cooler和warmer把溫度還原成加熱器能承受的溫度。若溫度是該加熱器可以承受的，則回傳0，使得cooler和warmer印出升溫或降溫後的溫度訊息。至於這些方法的具體定義，則放在附檔的Heater.java中。
>
