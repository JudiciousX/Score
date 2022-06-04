# Score
Score demo
ViewModel + LiveData + Data Binding + ViewModelSavedState 
实现进程即使在后台被系统杀死 数据也依旧存活 
对于后台应用 当系统内存不足时需要回收内存 有可能回收掉该部分的数据 
有两种方式对数据进行保存 
一是 使用onSaveInstanceState 的Bundle对数据进行保存 但是有一个缺点 数据安全性不能得到保证 数据需要设置为可更改模式 需要在Activity层对数据进行更改 
二是 使用ViewModelSavedState对数据进行更改，在Activity层传入SavedStateViewModelFactory 在ViewModel内部更改数据
