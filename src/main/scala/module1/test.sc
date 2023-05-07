import module1.opt.Option
import module1.list.List
import module1.list.List.{incList, shoutString}

//Тест кейс printIfAny, который будет печатать значение, если оно есть
Option.Some("12345").printIfAny()
// Если нет
Option.None.printIfAny()
//=============================================
//Тест кейс zip, который будет создавать Option от пары значений из 2-х Option
val first = Option.Some(1)
val second = Option.Some(2)
first.zip(second).printIfAny()
//Если пустые
Option.None.zip(Option.None)
//=============================================
//Тест кейс filter
val optional = Option.Some(1)
optional.filter(x => x == 1).printIfAny()
optional.filter(x => x < 1).printIfAny()
optional.filter(x => x > 1).printIfAny()
optional.filter(x => x > 0).printIfAny()
//=============================================
val list = List(1, 2, 3, 4)
//Тест кейс ::
val modificatedList = list.::(5)
//Тест кейс mkString
modificatedList.mkString(",") //5,1,2,3,4
//Тест кейс reverse
modificatedList.reverse() //::(4,::(3,::(2,::(1,::(5,Nil)))))
//Тест кейс map
modificatedList.map(x => x + 1).mkString(",") //6,2,3,4,5
//Тест кейс filter
modificatedList.filter(x => x < 3).mkString(",") //1,2
//Тест кейс incList
incList(modificatedList) //::(6,::(2,::(3,::(4,::(5,Nil)))))
//Тест кейс shoutString
shoutString(List("1", "2", "3")) //