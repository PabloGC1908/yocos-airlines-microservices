import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VuelosPageComponent } from './vuelos-page.component';

describe('VuelosPageComponent', () => {
  let component: VuelosPageComponent;
  let fixture: ComponentFixture<VuelosPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VuelosPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VuelosPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
