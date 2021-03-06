# MadeVipPresenter
MVP（Model-View-Presenter）

计算机依赖摩尔定律用数量的增长来解决问题，而人是用方式的改变来解决问题的。

MVP定义了Presenter和View之间的接口，让一些可以根据已有的接口协议去各自分别独立开发，以此去解决界面需求变化频繁的问题。

----------
----------
与用户界面相关的最大的问题就是大量的凌乱的代码

a.用户界面饮食复杂的逻辑用于维护界面相关对象

b.包含了应用程序状态的维护

----------
----------
用户界面的3大问题：状态 (State) ， 逻辑 (Logic) ，同步 (Synchronization)

状态 (State) ： 状态是用户界面最关心的问题之一。状态是用户界面数据的当前快照，在 Web 应用中，可能是 Session 级别的一个变量，在 Windows 应用中， 则可能只是界面级别的数据。 用户界面包含的状态越多， 则用户界面越复杂。

逻辑 (Logic) ： 用户界面往往包含界面逻辑，例如维护文本框、组合框或者其它任何界面元素，用户界面中这种逻辑越多，则用户界面越复杂。

同步 (Synchronization) ： 用户界面通常需要和业务组件协作，因此用户界面需要在界面元素与业务对象之间同步数据，如果用户界面包含的同步任务越多，则用户界面越复杂。

----------
----------
表现设计模式 (Presentation Design Pattern)

表现设计模式有助于解决上面列出的问题， 它的的基本逻辑就是创建一个额外的表现类 (Presenter) ，用来消化用户界面中复杂的逻辑，数据和同步的问题，从而使得用户界面变得简单明了。根据这个类承担责任的多少，决定了表现设计模式的类型，可能是 SC , PV , PM 等，也就是说，这个类的成熟度决定了它将是那种设计模式。