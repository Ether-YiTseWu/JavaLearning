## Overview
學習 *JAVA* ，並做些小小專案。最後的 *Final Project* 以 *BlueJ* 專案為基礎，做出圖片檢視器。有興趣者可往下查看，或自行下載該專案之[可執行檔](https://github.com/tailer954/JavaLearning/blob/master/Final%20Project/0056D057_FinalProject.jar)
>
## Small Project
### [01：Subjects Print](https://github.com/tailer954/JavaLearning/tree/master/Small%20Project/01)   
藉由 *keyboard.nextInt() 、 keyboard.next() 、 keyboard.nextInt()* 以及矩陣的使用，儲存使用者輸入的學科名稱、學分之後，再把矩陣內的資料印出    
>
### [02：Change Money](https://github.com/tailer954/JavaLearning/tree/master/Small%20Project/02)   
利用 *javax* 中的 *JOptionPane* 工具，寫出一對話框。該程式能自動地將使用者輸入的數字，換算成最少的鈔票、硬幣組合。本身學過 *Tkinter* 和 *QT* ，覺得需求沒有太高， *Tkinter* 或 *JOptionPane* 就能滿足需求了   
![](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/02/Change%20Money%20Result.JPG)
>
### [03：Loops Score](https://github.com/tailer954/JavaLearning/tree/master/Small%20Project/03)   
再次利用 *Javax* 中的 *JOptionPane* ，設計一個能計算平均成績且統計及格數與不及格數的程式。下方的五張圖片是對話框的樣貌。程式碼為一個無限迴圈，只有在使用者於「是否繼續輸入分數?」選擇「*Yes*」的時候，才會藉由 *if* 和 *break* 的跳出迴圈    
![](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/03/Loops%20Score%20Result.JPG)
>
### [04：Heater](https://github.com/tailer954/JavaLearning/tree/master/Small%20Project/04)    
藉由物件導向程式設計中的物件、多載、建構子、*Static Method* 等概念，寫出 *Heater* 這個類別。我一共寫了 *printTemp、warmer、setIncrement、cooler、printHeaterNum、getHeaterNum、getTemp* 等多個方法。其中，*Heater* 建構子有用到多載的概念；*cooler* 和 *warmer* 裡則有另外一個函數，*limitTemp* 。當升溫或降溫後，若溫度是該加熱器無法承受的， *limitTemp* 會印出錯誤訊息，並回傳1，使得 *cooler* 和 *warmer* 把溫度還原成加熱器能承受的溫度。若溫度是該加熱器可以承受的，則回傳0，使得 *cooler* 和 *warmer* 印出升溫或降溫後的溫度訊息。至於這些方法的具體定義，則放在附檔的 [Heater.java](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/04/04_Heater.java) 中
>
### [05：Exception](https://github.com/tailer954/JavaLearning/tree/master/Small%20Project/05)   
嘗試自己刻出 *Exception* ， *throws Exception* 並 *catch* 之，進而將錯誤訊息印出來。該專案中， *NameException* 這個類別繼承自 *Exception* ，因此在 *main* 函數中可使用來自 *Exception* 的方法， *getMessage()、printStackTrace()* 。另外， *PersonalData* 中定義何時要拋出 *Exception* 。*PersonalData* 中的 *setName* 方法 *throws NameException* ，並使用 *JAVA* 自帶的函數判斷使用者在輸入名字的時候，是否含有數字。若有數字混進姓名裡面的話，則 *throw new NameException* 。如此一來，在 *main* 函數中，便會執行 *catch (NameException e)* 裡面的程式，印出錯誤訊息。最後，無論程式是否有拋出例外，都會執行 *finally* 中的程式，把使用者輸入的訊息顯示出來      
>
>
![](https://github.com/tailer954/JavaLearning/blob/master/Small%20Project/05/Exception%20Warning.PNG)
>
### [06：DOME Project](https://github.com/tailer954/JavaLearning/tree/master/Small%20Project/06)   
由 *BlueJ* 的 *DOME Project* 擴增改寫而來。我增加讓使用者輸入 *item* 後，再把 *item* 寫入 *CSV* 檔案的功能。 *createFile* 這個方法可以建立多種類型的檔案，只要輸入正確的副檔名即可。將檔案建立完畢後，呼叫 *writeCSV* 。 *writeCSV* 中，先用 *PrintWriter* 建立 *outputStream* 物件，爾後在 *try* 中以 *outputStream.println* 方法，將已存在 *Database* 的資訊寫入。之後讓使用者自行輸入一個新的 *Item* 物件資訊，之後同樣用 *outputStream.println* 方法，將之寫進 *CSV* 檔案中

## Final Project
### 摘要 :   
以 *BlueJ* 上面， *chapter13* 的 *imageviewer-final* 為基礎做延伸。我新增了*CSV Record、Cut、Rotate、DisplayOnlyRed Filter、DisplayOnlyGreen Filter、DisplayOnlyBlue Filter、Mirror Button*、圖片長寬的顯示、經過濾波處理後將原來的圖片顯示出來…等功能
### 介面 :   
![](https://github.com/tailer954/JavaLearning/blob/master/Final%20Project/result.JPG)
>
