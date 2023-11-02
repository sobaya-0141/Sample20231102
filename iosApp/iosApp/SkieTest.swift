//
//  SkieTest.swift
//  iosApp
//
//  Created by 霜重 健児 on 2023/11/02.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Shared

final class SkieTest {
    func test() {
        Task.detached {
            let suspendTest = try? await TestKt.suspendTest()
            print(suspendTest)
            
            let flowTest: SkieSwiftFlow<KotlinInt> = TestKt.flowTest()
            for await it in flowTest {
                print(it)
            }
        }
    }
}
