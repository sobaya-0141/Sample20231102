import SwiftUI
import Shared

struct ContentView: View {
    let skieTest = SkieTest()
    var body: some View {
        VStack {
            Button(action: {
                skieTest.test()
            }, label: {
                /*@START_MENU_TOKEN@*/Text("Button")/*@END_MENU_TOKEN@*/
            })
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
