### TinyDumper
A Xposed Module that dumps dex files from memory.

一款能从内存中dump出dex文件的Xposed模块

### 使用说明
在LSPosed中启用模块，并勾选需要dump的应用，然后运行，应用运行后，如果不出意外的话，可在`/data/data/{应用包名}/dumper`目录下找到dump出来的dex文件。

我并没有做充分的验证，不保证所有应用都生效。有问题可以提issue。

### 免责声明
本应用仅供学术研究使用。对于违反相关法律、造成危害的滥用行为，开发者不负任何责任。
