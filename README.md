[TOC]



# ViewModel && Databinding

https://github.com/zhaojunchen/databinding-samples

1. 如何添加databinding

2. 编写ViewModel

3. 绑定databinding和ViewModel

4. 数据设置

   ```
   val popularity: LiveData<Popularity> = Transformations.map(_likes) {
           when {
               it > 9 -> Popularity.STAR
               it > 4 -> Popularity.POPULAR
               else -> Popularity.NORMAL
           }
       }
       
   val user = Transformations.switchMap(_user) { user ->
           Repository.getUser(user)
       }
   ```

   上述的2中方式，第一中使用场景如下：

   1. 涉及的LiveData变量的数据源来自本身、即是ViewModel中的定义，如likes、name、lastname等
   2. 设计的内容不适合展示、或者需要更好的形式展示，例子1. User存储人的身份证号，但是展示的时候只需要展示名字，此时就不需要展示身份证，对传输的User（`Livedata<User>`） 使用map转化为 名字(`LiveData<String>`)  ， 例子2:  现实的内容为数字需要切换为等级信息，本处就是这样

   第二种场景，数据的来源来来自网络，比如，查询的来自外部（数据库、网络）等，直接返回LiveData会导致每次返回的数据对象发生变化，无法实现监听! 解决方法

   1. 假设使用getUser(name:String) 请求参数，首选参数设置为一个私有的变量，然后用switchMap返回可观察对象！  

   2. 实际发现, 这个可观察的对象并未发生的对象应用并未发生变化！！！

      ![image-20210415183311861](4-15ViewModel+Databinding.assets/image-20210415183311861.png)

      ![image-20210415183416355](4-15ViewModel+Databinding.assets/image-20210415183416355.png)


Android Data Binding Library samples
===================================

A collection of samples using the [Android Data Binding Library](https://developer.android.com/topic/libraries/data-binding/index.html):

### Samples

* **[BasicSample](https://github.com/googlesamples/android-databinding/blob/master/BasicSample)** - (Kotlin) Shows basic usage of layout expressions, binding adapters, and integration with ViewModels.
* **[TwoWaySample](https://github.com/googlesamples/android-databinding/blob/master/TwoWaySample)** - (Kotlin) Shows usage of two-way data binding, advanced Binding Adapters, animations, converters and inverse converters.

### Other official samples using Data Binding

* **[Android Architecture Blueprints (todo-mvvm-live-kotlin branch)](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live-kotlin/)** - Shows basic Data Binding usage with architecture best practices and Architecture Components, in Kotlin.
* **[Android Architecture Components Samples](https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample)** - An advanced sample that uses the Architecture components, Dagger and the Github API, in Kotlin.
* **[Android Sunflower](https://github.com/googlesamples/android-sunflower)** - A gardening app illustrating Android development best practices with Android Jetpack, including Data Binding.

### Reporting Issues

You can report an [Issue](https://github.com/googlesamples/android-databinding/issues) on the samples using this repository. If you find an issue with the library related to build, report it using the [Gradle Plugin issue tracker](https://b.corp.google.com/issues/new?component=192709&template=842921). If it's related to the Android Studio integration, report it using the [Android Studio issue tracker](https://b.corp.google.com/issues/new?component=192708&template=840533).

License
-------

Copyright 2018 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
